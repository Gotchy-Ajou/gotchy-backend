# gotchy-backend

## DB (Entity)

---

### Users

- usersId → Long (PK)
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

- gotchyId → Long (PK)
- mode (모집인지 아닌지/모집 진행,완료 여부) → String
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

- postsId → Long (PK)
- title → String
- content → String
- author → String
- createdDate
- modifiedDate

### Hobby

- hobbyId → Long (PK)
- hobbyName → String
- hobbyLevel → String

### 기능↔API

---

### 사용자

- [x]  회원가입 → Users save [POST]
- [x]  정보 수정 → Users update [PUT]
- [ ]  로그인/로그아웃 → 사용자 계정
- [x]  프로필 정보 조회(사용자 접근) → Users findById [GET]
- [ ]  가치 신청 내역 조회 → Users에 있는 Gotchy List 이용
- [x]  공지사항 조회 → Posts findAll [GET], Posts findById [GET]
- [x]  취미별 레벨 등록 → Hobby save [POST]
- [ ]  취미별 레벨 조회 → Hobby findAll [GET]
- [x]  취미별 레벨 수정 → Hobby update [PUT]
- [ ]  가치 조회(날짜 선택) → Gotchy findAll [GET] , Gotchy findByDate [GET]
- [ ]  가치 조회(필터링)
- [x]  가치 상세 페이지 조회 → Gotchy findById [GET]
- [x]  가치 등록 (모집) → Gotchy save [POST]
- [ ]  가치 신청 → 
- [ ]  권한 부여 (공지사항 조회만 가능하게)

### 관리자

- [ ]  로그인/로그아웃 → 관리자 계정 Users 엔티티에 필요 (미리 db에 등록해놔야함)
- [ ]  권한 부여 (공지사항 등록, 수정, 조회, 삭제 가능)
- [x]  공지사항 등록 → Posts save [POST]
- [x]  공지사항 수정 → Posts update [PUT]
- [x]  공지사항 조회 → Posts findById [GET], Posts findAll [GET]
- [x]  공지사항 삭제 → Posts delete [DELETE]
- [x]  가치 등록 (관리자 등록) → Gotchy save [POST]
