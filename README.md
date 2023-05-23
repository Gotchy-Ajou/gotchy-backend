﻿# gotchy-backend
## DB (Entity)

---

### Users

- usersId → Long
- password → String
- name → String
- nickname → String
- photoUrl → String
- gender → String
- age → int
- phone → String
- region → String
- manner → String
- account → String
- Role (enum)
- createdDate
- modifiedDate

### Gotchy

- gotchyId → Long
- mode (모집인지 아닌지) → String
- gotchyHobby → String
- date → String
- location → String
- photoUrl → String
- price → int
- headcount → int
- level → String
- gender → String
- useTime → String
- createdDate
- modifiedDate

### Posts

- postsId → Long
- title → String
- content → String
- author → String
- createdDate
- modifiedDate

### Hobby

- hobbyId → Long
- hobbyName → String
- hobbyLevel → String

### 기능↔API

---

### 사용자

1. 사용자 회원가입 → Users save [POST]
2. 사용자 정보 수정 → Users update [PUT] 
3. 로그인/로그아웃 → 사용자 계정
4. 사용자 프로필 조회 → Users findById [GET]
5. 가치 신청 내역 조회 → Gotchy list로 전체 조회
6. 공지사항 조회 → Posts findById [GET]
7. 사용자 취미별 레벨 등록 → Hobby save [POST]
8. 사용자 취미별 레벨 조회 → Hobby findByName [GET]
9. 사용자 취미별 레벨 수정 → Hobby update [PUT]
10. 가치 조회(날짜 선택) → Gotchy findByDate [GET]
11. 가치 조회(필터링)
12. 가치 상세 페이지 조회 → Gotchy findById [GET]
13. 가치 신청 → Gotchy save [POST]
14. 가치 모집 등록 → Gotchy save [POST]
15. 채팅 기능

### 관리자

1. 로그인/로그아웃 → 관리자 계정 필요
2. 공지사항 등록, 수정, 조회 삭제 → Posts CRUD
