# Client Authentication

Utilização do spring initializr do (https://start.spring.io/)

Commit: chore: setup inicial com Spring Boot 3.5.3, Java 17
Branch: feature/init

Todas as dependências adicionadas no pom.xml foram extraídas do mavenrepository

Monitorar a saúde da sua aplicação foi adicionado o Spring Boot Actuator Health Check
http://localhost:8080/client-authentication/actuator/health

Primeiro vou criar minha interface ValidatorService abstrata com a função isValid()

Depois vou fazer as classes Impl para cada função
 -ValidatesCharacterSizeServiceImpl
 -ValidatesLowercaseServiceImpl
 -ValidatesUppercaseServiceImpl
 -ValidatesSpecialCharactersServiceImpl
 -Em cada Impl ele vai abstrair a interface isValid do ValidatorService e vou usar o @Override para implementar a validação

Depois vou criar uma class Impl chamada PasswordValidationServiceImpl para chamar a classe abstrata ValidatorService e suas implementações

Vou abstrair em uma interface PasswordValidationService e chamar na AuthenticationController (view)


Commit: feat: Estruturação do projeto pacotes e classes(distribuição das responsabilidades) sem implementação
Branch: feature/structure
