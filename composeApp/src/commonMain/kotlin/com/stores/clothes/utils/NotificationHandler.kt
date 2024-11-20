package com.stores.clothes.utils

import androidx.navigation.NavHostController

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.stores.clothes.navigation.Destinations


//class NotificationHandler {
//    companion object{
//         var CurrentAction : NotificationAction = NotificationAction.UNKNOWN
//    }
//}
//
//
//
//fun handleInAppLaunchedNotificationActions(navController: NavHostController){
//    NotifierManager.addListener(object : NotifierManager.Listener {
//        override fun onPayloadData(data: PayloadData) {
//            println("Push Notification payloadData: $data") //PayloadData is just typeAlias for Map<String,*>.
//            CoroutineScope(Dispatchers.Main).launch {
//            //    notificationRoute(NotificationAction.valueOf(data.getValue("action").toString()),navController)
//            }
//        }
//
//        override fun onNotificationClicked(data: PayloadData) {
//            super.onNotificationClicked(data)
//            CoroutineScope(Dispatchers.Main).launch {
//                delay(1000)
//                notificationRoute(NotificationAction.valueOf(data.getValue("action").toString()), navController)
//            }
//        }
//        override fun onNewToken(token: String) {
//            println("onNewToken: $token") //Update user token in the server if needed
//        }
//    })
//}
//
//// Function to handle navigation
//fun setupNotificationAction(action: NotificationAction) {
//    CurrentAction = action
//}
//
//
//fun notificationRoute(action:NotificationAction, navController:NavHostController){
//    when(action){
//        NotificationAction.OPEN_HOME->{
//            // add implementation
//        }
//        NotificationAction.OPEN_ADD_NEW->{
//         //   navController.navigateToAddNew()
//        }
//        NotificationAction.UNKNOWN->{
//            // add implementation
//        }
//    }
//}
//
//fun fetchStartDestination(action:NotificationAction): Destinations =  when(action){
//    NotificationAction.OPEN_HOME->  Destinations.StartScreen
//    NotificationAction.OPEN_ADD_NEW-> Destinations.AddNewScreen
//    NotificationAction.UNKNOWN-> Destinations.StartScreen
//}
//
//enum class NotificationAction {
//    OPEN_HOME,
//    OPEN_ADD_NEW,
//    UNKNOWN
//}