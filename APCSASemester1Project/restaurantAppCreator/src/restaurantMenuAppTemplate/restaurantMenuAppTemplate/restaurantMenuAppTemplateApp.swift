//
//  restaurantMenuAppTemplateApp.swift
//  restaurantMenuAppTemplate
//
//  Created by Aviral Mehrotra on 12/6/21.
//

import SwiftUI

@main
struct restaurantMenuAppTemplateApp: App {
    var body: some Scene {
        WindowGroup {
            // ContentView()
            ItemView(menuItem: menuData[0])
        }
    }
}
