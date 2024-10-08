package com.seven_sheesh.greventure.presentation.ui.navigation.nav_host

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.seven_sheesh.greventure.presentation.ui.design_system.GreventureScheme
import com.seven_sheesh.greventure.presentation.ui.navigation.nav_obj.HomeNavObj
import com.seven_sheesh.greventure.presentation.ui.widget.common.Navbar
import com.seven_sheesh.greventure.presentation.view.bookmark.BookmarkScreen
import com.seven_sheesh.greventure.presentation.view.bookmark.HistoryBookmarkScreen
import com.seven_sheesh.greventure.presentation.view.home.CityScreen
import com.seven_sheesh.greventure.presentation.view.home.EventScreen
import com.seven_sheesh.greventure.presentation.view.home.HomeScreen
import com.seven_sheesh.greventure.presentation.view.home.NewsDetailScreen
import com.seven_sheesh.greventure.presentation.view.home.NewsScreen
import com.seven_sheesh.greventure.presentation.view.home.NotificationScreen
import com.seven_sheesh.greventure.presentation.view.maps.DetailScreen
import com.seven_sheesh.greventure.presentation.view.maps.DiscussionScreen
import com.seven_sheesh.greventure.presentation.view.maps.MapsScreen
import com.seven_sheesh.greventure.presentation.view.profile.CreateBubbleScreen1
import com.seven_sheesh.greventure.presentation.view.profile.CreateBubbleScreen2
import com.seven_sheesh.greventure.presentation.view.profile.CreateBubbleScreen3
import com.seven_sheesh.greventure.presentation.view.profile.CreateBubbleScreenPick
import com.seven_sheesh.greventure.presentation.view.profile.EditProfileScreen
import com.seven_sheesh.greventure.presentation.view.profile.ProfileScreen
import com.seven_sheesh.greventure.presentation.view.profile.YourBubbleScreen
import com.seven_sheesh.greventure.presentation.viewmodel.CreateBubbleViewModel
import com.seven_sheesh.greventure.presentation.viewmodel.MapsViewModel
import com.seven_sheesh.greventure.presentation.viewmodel.NavbarViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun HomeNavHost(parentNavController: NavController = rememberNavController()){
    val homeNavController = rememberNavController()
    val navbarViewModel   = hiltViewModel<NavbarViewModel>()
    val mapsViewModel     = hiltViewModel<MapsViewModel>()
    val createBubbleViewModel = hiltViewModel<CreateBubbleViewModel>()

    Scaffold(
        containerColor = GreventureScheme.White.color,
        contentColor = GreventureScheme.White.color,
        bottomBar = {
            Navbar(
                homeNavController = homeNavController,
                navbarViewModel = navbarViewModel
            )
        }
    ) {
        NavHost(navController = homeNavController, startDestination = HomeNavObj.HomeScreen.route, builder = {
            composable(
                route = HomeNavObj.HomeScreen.route,
                content = {
                    HomeScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.CityScreen.route,
                content = {
                    CityScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.NotificationScreen.route,
                content = {
                    NotificationScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.EventScreen.route,
                content = {
                    EventScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.NewsScreen.route,
                content = {
                    NewsScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.NewsDetailScreen.route,
                arguments = listOf(navArgument("news_id") { type = NavType.StringType }),
                content = {
                        val newsId = it.arguments?.getString("news_id") ?: ""
                    NewsDetailScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                        newsId = newsId
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.MapsScreen.route,
                content = {
                    MapsScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                        mapsViewModel = mapsViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.DetailScreen.route,
                arguments = listOf(navArgument("bubble_id") { type = NavType.StringType }),
                content = {
                    val bubbleId = it.arguments?.getString("bubble_id") ?: ""
                    DetailScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                        mapsViewModel = mapsViewModel,
                        bubbleId = bubbleId
                    )
                },
                enterTransition = {
                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up, tween(700))
                },
                popExitTransition = {
                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down, tween(700))
                }
            )


            composable(
                route = HomeNavObj.DiscussionScreen.route,
                arguments = listOf(navArgument("thread_id") { type = NavType.StringType }),
                content = {
                    val threadId = it.arguments?.getString("thread_id") ?: ""
                    DiscussionScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                        threadId = threadId
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.BookmarkScreen.route,
                content = {
                    BookmarkScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.ProfileScreen.route,
                content = {
                    ProfileScreen(
                        homeNavController = homeNavController,
                        parentNavController = parentNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.YourBubbleScreen.route,
                content = {
                    YourBubbleScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.EditProfileScreen.route,
                content = {
                    EditProfileScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.CreateBubble1.route,
                content = {
                    CreateBubbleScreen1(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                        createBubbleViewModel = createBubbleViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.CreateBubble2.route,
                content = {
                    CreateBubbleScreen2(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                        createBubbleViewModel = createBubbleViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.CreateBubble3.route,
                content = {
                    CreateBubbleScreen3(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                        createBubbleViewModel = createBubbleViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.CreateBubblePick.route,
                content = {
                    CreateBubbleScreenPick(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel,
                        createBubbleViewModel = createBubbleViewModel,
                        mapsViewModel = mapsViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )

            composable(
                route = HomeNavObj.HistoryBookmarkScreen.route,
                content = {
                    HistoryBookmarkScreen(
                        homeNavController = homeNavController,
                        navbarViewModel = navbarViewModel
                    )
                }, enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up, tween(700)
                    )
                }, popExitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
                    )
                }
            )
        })
    }
}