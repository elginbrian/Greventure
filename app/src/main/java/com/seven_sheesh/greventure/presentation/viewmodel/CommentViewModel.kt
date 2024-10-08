package com.seven_sheesh.greventure.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seven_sheesh.greventure.data.repository.CommentRepositoryImpl
import com.seven_sheesh.greventure.data.repository.UserRepositoryImpl
import com.seven_sheesh.greventure.domain.model.Comment
import com.seven_sheesh.greventure.domain.model.Thread
import com.seven_sheesh.greventure.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val commentRepository: CommentRepositoryImpl,
    private val userRepository: UserRepositoryImpl
) : ViewModel() {

    private val _commentListState = MutableStateFlow<Pair<String, List<Comment>>>(Pair("Loading...", emptyList()))
    val commentListState: StateFlow<Pair<String, List<Comment>>> get() = _commentListState

    private val _commentState = MutableStateFlow<Pair<String, Comment?>>(Pair("Loading...", null))
    val commentState: StateFlow<Pair<String, Comment?>> get() = _commentState

    private val _messageState = MutableStateFlow<String>("")
    val messageState: StateFlow<String> get() = _messageState

    private val _threadUserState = MutableStateFlow<Map<Thread, User>?>(null)
    val threadUserState: StateFlow<Map<Thread, User>?> get() = _threadUserState

    private val _commentUserListState = MutableStateFlow<List<Map<Comment, User>>>(emptyList())
    val commentUserListState: StateFlow<List<Map<Comment, User>>> get() = _commentUserListState

    fun loadAllComments() {
        viewModelScope.launch {
            commentRepository.getAllComments()
                .collect { commentResult ->
                    _commentListState.value = commentResult

                    val comments = commentResult.second
                    val commentUserList = mutableListOf<Map<Comment, User>>()

                    comments.forEach { comment ->
                        val userId = comment.userId // assuming Comment has a userId field
                        userRepository.getUserById(comment.userId.toString()).collect { userResult ->
                            userResult.second?.let { user ->
                                // Create a map of Comment to User and add it to the list
                                commentUserList.add(mapOf(comment to user))
                            }
                        }
                    }

                    // Update state with the list of maps of comments and their users
                    _commentUserListState.value = commentUserList
                }
        }
    }

    fun loadCommentById(commentId: String) {
        viewModelScope.launch {
            commentRepository.getCommentById(commentId)
                .collect { result ->
                    _commentState.value = result
                }
        }
    }

    fun loadCommentFromThreadList(list: List<Thread>) {
        viewModelScope.launch {
            val commentUserList = mutableListOf<Map<Comment, User>>()

            list.forEach { thread ->
                commentRepository.getCommentsByThreadId(thread.id)
                    .collect { commentResult ->
                        _commentListState.value = _commentListState.value.copy(
                            second = _commentListState.value.second + commentResult.second
                        )

                        val comments = commentResult.second
                        comments.forEach { comment ->
                            val userId = comment.userId // assuming Comment has a userId field
                            userRepository.getUserById(comment.userId.toString()).collect { userResult ->
                                userResult.second?.let { user ->
                                    // Create a map of Comment to User and add it to the list
                                    commentUserList.add(mapOf(comment to user))
                                }
                            }
                        }

                        // Update state with the list of maps of comments and their users
                        _commentUserListState.value = commentUserList
                    }
            }
        }
    }

    fun upsertComment(comment: Comment) {
        viewModelScope.launch {
            commentRepository.upsertComment(comment)
                .collect { message ->
                    _messageState.value = message
                }
        }
    }

    fun deleteComment(commentId: String) {
        viewModelScope.launch {
            commentRepository.deleteComment(commentId)
                .collect { message ->
                    _messageState.value = message
                }
        }
    }

    fun loadCommentByThreadId(threadId: String) {
        viewModelScope.launch {
            commentRepository.getCommentsByThreadId(threadId)
                .collect { commentResult ->
                    _commentListState.value = commentResult

                    val comments = commentResult.second
                    val commentUserList = mutableListOf<Map<Comment, User>>()

                    comments.forEach { comment ->
                        val userId = comment.userId // assuming Comment has a userId field
                        userRepository.getUserById(comment.userId.toString()).collect { userResult ->
                            userResult.second?.let { user ->
                                // Create a map of Comment to User and add it to the list
                                commentUserList.add(mapOf(comment to user))
                            }
                        }
                    }

                    // Update state with the list of maps of comments and their users
                    _commentUserListState.value = commentUserList
                }
        }
    }
}
