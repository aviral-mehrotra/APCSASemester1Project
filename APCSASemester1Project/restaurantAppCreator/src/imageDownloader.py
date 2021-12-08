import json
import urllib.request

with open("/Users/aviralmehrotra/Downloads/Code/Java/APCSASemester1Project/restaurantAppCreator/src/restaurantMenuAppTemplate/restaurantMenuAppTemplate/output.json") as file:
    data_with_name = json.load(file)

data_without_name = list(data_with_name.values())


with open("/Users/aviralmehrotra/Downloads/Code/Java/APCSASemester1Project/restaurantAppCreator/src/restaurantMenuAppTemplate/restaurantMenuAppTemplate/dataOutput.json", 'r') as file:
    data = json.load(file)

    for i in range(len(data)):
        data[i]['imageName'] = "image" + str(i)

with open("/Users/aviralmehrotra/Downloads/Code/Java/APCSASemester1Project/restaurantAppCreator/src/restaurantMenuAppTemplate/restaurantMenuAppTemplate/dataOutput.json", 'w') as file:
    json.dump(data, file)

for i in range(len(data_without_name[0])):
    info = list(data_without_name[0][i].values())

    image_url = info[0]["item_url"]

    print(image_url)
    
    urllib.request.urlretrieve(image_url, "/Users/aviralmehrotra/Downloads/Code/Java/APCSASemester1Project/restaurantAppCreator/src/restaurantMenuAppTemplate/restaurantMenuAppTemplate/image" + str(i) + ".jpg")
