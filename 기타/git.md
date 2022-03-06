## Desktop으로 재작성





---

## 크롤링, api 실습

```python
# 웹 크롤링 
# 이름을 통한 나이 추정

import requests

lst = ['tak','tony','eric','musk']
url = 'https://api.agify.io?name='

for i in range(len(lst)):
    url = url+(lst[i]) 
    newresponse = requests.get(url).json()
    print("%s의 나이는 : %d " % (lst[i],(newresponse['age'])))
    url = 'https://api.nationalize.io?name='
```



```python
# 이름을 통한 국가 추정
# dict의 중첩 구조

import requests
url = 'https://api.nationalize.io?name=michael'
response =  requests.get(url).json() # json -> dict 전환

print("1 : " , response)
print("2 : ", response['country'])
print("3 : " ,response['country'][0])
print("가장 유력한 국가는 : ",response['country'][0]['country_id'])

# dict_이름[키값] => 밸류값

```

