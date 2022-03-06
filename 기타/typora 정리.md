

# markdown



#한개 매우 가벼운 텍스트를 구조화하는 (markup) 언어



## 제목(heading)

##두개 이런식으로 구조화가 가능

문서의 제목을 나타내기 위해 사용되며, #띄어쓰기를 통해 제목의 수준을 정한다



### 제목3

#### 제목4

##### 제목5

###### 제목6



## 목록

* 순서가 없는 목록 *로 함
* 순서가 없는 목록입니다
  * tab 누르면 하위 목록 작성 가능	
* shift tab 으로 상위 목록 토글 가능

엔터 두번으로 나옴



1. 순서가 있는 목록은 숫자하고 콤마로 작성 가능
   1. 이것도 탭으로 하위 목록 작성 가능
2. 이렇게 shift tab



## 코드 블록

코드블록은 backtick ``` (이걸로 코드를 감싸야함)로 구성되며 특정 언어를 같이 작성하면 syntax highlighting을 지원한다

ex)

```python
​```python 백틱3개 파이썬으로 코드 블록 생성 가능
```

```python
print('hi') 
# 주석
if True:
    print("참")
# 이와 같이 코드 정리할떄는 마크다운 언어가 좋다
```

```html
<!-- 주석 -->
# 주석아님
// 주석아님
```



## 인라인 코드블록

backtick `` 하나로 감싸서 문장 내에 있는 코드 (함수이름 등)를 블록화 할때 사용

`random` 모듈을 활용하는것을 배웠다

`print` 함수는 



## 표(table)

본문 누르고 표 , 오른쪽 클릭하고 표 가능 문법이 어려워서 ui 쓰는게 나음

|      |      |      |
| ---- | ---- | ---- |
|      |      |      |
|      |      |      |
|      |      |      |







## 이미지



![보노보노](md-images/%EB%B3%B4%EB%85%B8%EB%B3%B4%EB%85%B8.PNG)



## 링크

구글https://google.com

링크는 ctrl 누르고 클릭

[구글 ]: https://google.com	""구글""

[구글](www.gooogle.com) // 이렇게 작성이 가능

[~~~] : www.도메인.~~

[] 쓰고 : 도메인



## 인용문



> 인용문

`>` 으로 사용

## 기타



`---` 이거 세개 ??

*기울임* ```*```으로 감싸기* *

**굵게** ```**``` 으로 감싸기 ** **





## 7.15 내용



### git

분산 버전 관리 시스템



git init 

git status 으로 변경 감지

//

git log 변경 관리 버전 확인

//

touch 파일 만들기

//

git commit 중간 버전 저장

//

add -> commit -> push

//

수정 전 git status는 반영전

수정 후 git add a.txt  반영이 되고

git status 를 하면 반영 완료가 확인이 됨

git commit -m 'A 수정' 해당 커밋에 대한 내용을 메세지로 저장

//

git log를 통해서 commit들을 확인 가능

//

해당 폴더 하위에 있는것이 포함

바탕화면은 디렉토리 설정 조심!



### 기본 명령어

저장소 repository 생성

```
$ git init // ?
```

숨김 폴더 확인



### 기본 버전 관리 흐름

git은 저장소 내에 모든 파일의 변경사항을 추적함 

작업 완료하고 `add` -> `commit`을 통해 버전을 기록한다

워킹 디렉토리에서 add 통해 stagingarea 상태로 (staged)로 변경

staged 상태인 파일들을 모두 commit 명령을 통해 반영, 버전기록



### add

```bash
$ git add a.txt
$ git add test/
$ git add .
```



### commit

```bash
$ git commit -m '커밋 메세지'
```

커밋 메세지는 현재 버전에 대해 알 수 있도록 작성

커밋 확인 위해선 `git log`로 확인



### 상태확인

#### `status` 

> 워킹 디렉토리와 스테이지드 확인 가능

``` bash
$ git status

```



#### `log` 

```bash
$ git log
$ git log --oneline 한줄로 간략히 알 수 있음
```



