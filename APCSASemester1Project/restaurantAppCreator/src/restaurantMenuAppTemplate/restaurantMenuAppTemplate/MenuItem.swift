//
//  MenuItem.swift
//  restaurantMenuAppTemplate
//
//  Created by Aviral Mehrotra on 12/6/21.
//

import SwiftUI


struct MenuItem: Hashable, Codable, Identifiable {
    var price: Double
    var imageURL: String
    var name: String
    var description: String
    var id: Int
    var type: String
    var imageName: String
    
}
