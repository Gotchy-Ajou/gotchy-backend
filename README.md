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
- gotchyList
- hobbyList
- postsList

### Gotchy

- gotchyId → Long (PK)
- users (JoinColumn) → Users (객체)
- gotchyName → String
- mode (모집인지 아닌지/모집 진행,완료 여부) → String
- gotchyHobby → String
- gotchyDate → String
- gotchyTime → String
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
- author (JoinColumn) → Users (객체)
- title → String
- content → String
- createdDate
- modifiedDate

### Hobby

- hobbyId → Long (PK)
- hobbyName → String
- hobbyLevel → String
- users (JoinColumn) → Users

### 기능↔API

---

### 사용자

- [x]  회원가입 → UsersController save [POST]
- [x]  정보 수정 → UsersController update [PUT]
- [x]  로그인/로그아웃 → 사용자 계정
- [x]  권한 부여 (공지사항 조회만 가능하게)
- [x]  프로필 정보 조회(사용자 접근) → UsersController findById [GET]
- [x]  가치 신청 내역 조회 → UsersController findMyApply [GET]
- [x]  공지사항 조회 → (전체)PostsController findAll [GET], (상세, 단건)PostsController findById [GET]
- [x]  취미별 레벨 등록 → HobbyController save [POST]
- [x]  취미별 레벨 조회 → HobbyController findAll [GET]
- [x]  취미별 레벨 수정 → HobbyController update [PUT]
- [x]  가치 조회(날짜별 조회) → GotchyController findByDate [GET]
- [x]  가치 조회(필터링 적용 시)
- [x]  가치 상세 페이지 조회 → GotchyController findById [GET]
- [x]  가치 등록 (모집) → GotchyController save [POST]
- [x]  가치 신청 → UsersController apply [POST]

### 관리자

- [x]  로그인/로그아웃 → 관리자 계정 Users 엔티티에 필요 (미리 db에 등록해놔야함)
- [x]  권한 부여 (공지사항 등록, 수정, 조회, 삭제 가능)
- [x]  공지사항 등록 → PostsController save [POST]
- [x]  공지사항 수정 → PostsController update [PUT]
- [x]  공지사항 조회 → (전체)PostsController findAll [GET], (상세, 단건)PostsController findById [GET]
- [x]  공지사항 삭제 → PostsController delete [DELETE]
- [x]  가치 등록 (관리자 등록) → GotchyController save [POST]

### 연관관계 매핑
- Posts, Users (양방향)
- Gotchy → Users (단방향)
- Hobby → Users (단방향)
