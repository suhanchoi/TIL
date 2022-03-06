## Django





### models

models.py 에 orm 활용 코딩

```django
```







### Migrations

* django가 model에 생긴 변화를 DB에 반영하는 방법

```django
<!-- 명령어 -->
ex) python manage.py makemigrations

makemigrations # 핵심
# model 변경한 것에 기반한 새로운 마이그레이션(설계도) 만들 때 사용

migrate # 핵심
# 마이그레이션을 db에 반영하기 위해 사용
# 설계도를 실제 db에 반영하는 과정
# 모델에서의 변경 사항들과 db의 스키마가 동기화를 이룸

sqlmigrates
# sql 문법으로 어떻게 표현되는지 미리 알 수 있음
ex) python manage.py sqlmigrate articles 0001

showmigrations
# project 전체의 마이그레이션 상태 확인하기 위해 사용 
# migrate 여부 파악 가능 -> X 는 반영 된것
```

* pk 자동으로 추가 됨

앱이름_클래스이름 으로 sqlite table 생성됨



* 순서 models.py -> makemigrations (migrations 파일 생성)-> migrate (db 반영)



### datafield's options

```django
auto_now_add -> created_at
# 최초 생성 일자
# 수정 되더라도 값은 변하지 않음

auto_now -> updated_at
# 최종 수정 일자
# 수정시 마다 갱신
```



### Database API

* db 조작하기 위한 도구

  Article . objects . all()

  class	manage	QuerySet API

* Manager

  * 기본적으로 모든 django 모델 클래스에 objects 라는 Manager 추가

* QuerySet API

  * db로부터 전달받은 객체 목록
  * 0개 혹은 1개 이상일 수 있음
  * db로부터 조회 필터 정렬 등 수행 가능

* django-extensions pip로 설치 후 settings - installed_apps에 추가
* python manage.py shell_plus -> 모델 반영한 쉘 시작



### CRUD

* 생성C 읽기R 갱신U 삭제D

* READ

  * Article.objects.all()
  * 새로운 querysets return <all()> 하고 안하는 <create()> 방법
    * all() 현재 QuerySet의 복사본을 반환
    * get() 
      * 주어진 lookup 매개변수와 일치하는 객체 1개를 반환
    * filter
      * 주어진 llokup 매개변수와 일치하는 객체를 포함하는 새로운 QuerySet을 반환

* CREATE

  * ````python
    # shell_plus
    article = Article()
    article.title = 'first' # 작성
    article.content = 'django!' # 작성
    article.save # 반영
    Article.objects.all() 
    ````

  * ```python
    article = Article(title='second', content='django!!')
    article.save()
    # save() 즉 반영을 하지 않으면 pk 값이 할당되지 않는다
    ```

  * ```python 
    Article.objects.create(title='third', content='django!!!')
    # save() 불필요
    ```
    
  * save() 호출 전까진 객체 id 값 알 수 없음 -> db에서 계산되기 때문
  
  *  
  
* INSERT

  * 선택하고 수정
  * 수정 후 save()

* DELETE

  * article.delete() # 객체.delete()
  * 삭제의 개수가 포함된 딕셔너리 반환함



### HTTP method

* GET
  * 특정 리소스 가져오도록 요청할때 사용
  * CRUD 에서 R 담당
* POST
  * 서버로 데이터를 전송할 때 사용
  * http body에 담아 전송
  * CRUD 에서 C/U/D 담당
  * csrf 토큰 추가하여 전송









