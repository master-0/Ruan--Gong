import requests
import json
def getId(string):
    id = ""
    index = 20
    while index < len(string) and string[index] != "-":
        id = id + string[index]
        index = index + 1
    return id
def getDate(string):
    date = string[8] + string[9] + "/" + string[5] + string[6] + "/2020"
    return date
    
def check(string):
    ignoreList = [':','@','.']
    for i in range(len(string)):
        if string[i] in ignoreList:
            return False
    return True

def getMethod(string):
    indexEnd = -1
    ansString = ""
    for i in range(len(string)):
        if string[i] == "(":
            indexEnd = i - 1
    while indexEnd >= 20:
        if string[indexEnd] == '.':
            break
        ansString = string[indexEnd] + ansString
        indexEnd = indexEnd - 1
    return ansString

countMap = {}
dateCountMap = {}
f = open("/var/www/html/exception.txt")
line = f.readline()
while line:
    if line[0] == '2':
        id = getId(line)
        if len(id) >= 5 and check(id):
            date = getDate(line)
            method = getMethod(line)
            if id not in dateCountMap:
                dateCountMap[id] = {}
                dateCountMap[id][date] = 1
            else:
                if date not in dateCountMap[id]:
                    dateCountMap[id][date] = 1
                else:
                    dateCountMap[id][date] += 1
            if method == "":
                continue
            if id not in countMap:
                countMap[id] = {}
                countMap[id][method] = 1
            else:
                if method not in countMap[id]:
                    countMap[id][method] = 1
                else:
                    countMap[id][method] = countMap[id][method] + 1
    line = f.readline()
f.close()
# for key,value in countMap.items():
#     print(key + ":")
#     print(value)

# print(" --------------------- ")
for key,value in dateCountMap.items():
    f = open('/home/python_project/file/' + key + ".txt", 'w')
    for key1, value1 in value.items():
        f.writelines(key1 + " " + str(value1) + " ")
    f.close()
    print(value)

