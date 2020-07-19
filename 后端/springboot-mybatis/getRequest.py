import requests
import json
if __name__ == '__main__':
    url = "http://aaedion.club:8002/api/devId?devId=-1"
    response = requests.get(url).text
    text = json.loads(response)