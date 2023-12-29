# 온라인 쇼핑몰 프로젝트 - 백엔드

### Security, Validation, JPA 

### Security : RestAPI에 대해 인증된 유저에게만 특정한 권한도 부여하여 리소스 컨트롤을 가능하게 하기위해서 사용

### JPA 
**사용하는 이유는 객체중심으로 이루어지므로 반복된 CRUD 을 작성하지 않아도되고, 객체중심으로 작성되어 유지 보수에도 도움이 된다.**

**객체 매핑을 자동적으로 처리해주고, 객체 중심으로 생산성 증가하며, 성능 최적화가 가능해진다.**

### Validation
**도메인 규칙이 가득한 엔터티 객체가 복잡해지는 것을 막아주고, 분산된 중복 VALIDATION 코드를 제거해준다.** 

Server
.
└──--- shopping_back
    ├── common -----object   공통적인 객체들의 리스트 
    ├── config        
    |── controller            테스트용데이터
    │   ├── AuthController            테스트용이미지
    │   └── AdminController           자주쓰이고 반복적인 함수
    │   ├── ProductController 테스트용이미지
    │   └── OrderProductController 자주쓰이고 반복적인 함수   
    │   ├── ProductController     테스트용이미지
    │   └── PayController  자주쓰이고 반복적인 함수       
    ├── repository          
    │   ├── UserRepository    채팅방페이지
    │   ├── AdminRepository   유저 확인용 컴포넌트
    │   ├── ProductRepository 상품상세페이지
    │   ├── OrderProductRepository  위치변경페이지
    │   ├── ProductRepository   내 계정 페이지
    │   ├── PayRepository         상품추가페이지
    ├── service          클래스 인터페이스
    └── scss                스타일폴더

