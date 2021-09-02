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











