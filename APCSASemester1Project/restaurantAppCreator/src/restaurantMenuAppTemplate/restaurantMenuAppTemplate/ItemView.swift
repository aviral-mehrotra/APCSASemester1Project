//
//  ItemView.swift
//  restaurantMenuAppTemplate
//
//  Created by Aviral Mehrotra on 12/6/21.
//

import SwiftUI

struct ItemView: View {
    
    var menuItem: MenuItem
    
    var body: some View {
        
        NavigationView {
            ScrollView(.vertical, showsIndicators: false) {
                Spacer(minLength: 20)
                
                ForEach(menuData) { item in
                    
                    HStack(spacing: 20) {
                        Image(item.imageName)
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                            .frame(width: 200, height: 130)
                            .cornerRadius(20)
                            .shadow(radius: 3)
                        VStack() {
                            Text(item.name)
                                .font(.headline)
                                .foregroundColor(Color.black)
                            Text(item.type)
                                .font(.subheadline)
                                .foregroundColor(Color.black)
                            Text("$" + String(item.price))
                                .font(.subheadline)
                                .foregroundColor(Color.black)
                            Text(item.description)
                                .font(.subheadline)
                                .foregroundColor(Color.black)
                                .lineLimit(nil)
                                .frame(width: 150, height: 70, alignment: .leading)
                        }
                    }
                    .padding(.bottom)
                }
            }
            .navigationBarTitle(Text("Menu"))
        }
    }
}

struct ItemView_Previews: PreviewProvider {
    static var previews: some View {
        ItemView(menuItem: menuData[0])
    }
}
