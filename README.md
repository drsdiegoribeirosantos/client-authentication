# Client Authentication

Utilização do spring initializr do (https://start.spring.io/)

Commit: chore: setup inicial com Spring Boot 3.5.3, Java 17
Branch: feature/init

----------------------------

Todas as dependências adicionadas no pom.xml foram extraídas do mavenrepository

----------------------------

Monitorar a saúde da sua aplicação foi adicionado o Spring Boot Actuator Health Check
http://localhost:8080/client-authentication/actuator/health

----------------------------
Ideias antes de implementar estrutura Solid(Dividir a responsabilidades na classes e abstração)

Primeiro vou criar minha interface ValidatorService abstrata com a função isValid()

Depois vou fazer as classes Impl para cada função
 -CharacterSizeValidatorServiceImpl
 -LowercaseValidatorServiceImpl
 -NumericDigitValidatorServiceImpl
 -UppercaseValidatorServiceImpl
 -SpecialCharactersValidatorServiceImpl
 -Em cada Impl ele vai abstrair a interface isValid do ValidatorService e vou usar o @Override para implementar a validação

Depois vou criar uma class Impl chamada PasswordValidationServiceImpl para chamar a classe abstrata ValidatorService e suas implementações

Vou abstrair em uma interface PasswordValidationService e chamar na AuthenticationController (view)


Commit: feat: Estruturação do projeto pacotes e classes(distribuição das responsabilidades) sem implementação
Branch: feature/structure


----------------------------
Construção dos métodos de validação
*CharacterSizeValidatorServiceImpl função isValid()
Criei uma constante ALLOWED_SPECIAL_CHARACTERS pois é a lista de caracteres permitidos e não é alterado

Criei uma variável repeatedCharacters para salvar os caracteres a cada interação e verificar se já foi utilizado o caracter na senha, e assim não permitindo caracter repetido se tiver repetido se torna abortivo e da um return false

Utilizei a conversão do Character para String para utilizar o contains e percorrer a lista

A variável que será definida se é valido é a validCharacters e nas interações do meu laço se der true ele será valido mas não irá dar um return até percorrer toda a lista por isso deixei o return dele depois do laço




*CharacterSizeValidatorServiceImpl função isValid
Faço uma primeira validação se o dado de request for null para não processar nada e da um return false

Prompt IA utilizado:
Request: Qual expressão regular para remover qualquer tipo de espaço
Retorno: "\\s"

Removo todos os espaços para não validar como tamanho valido e depois vejo o tamanho através do .length()




*NumericDigitValidatorServiceImpl função isValid
Aqui eu iria utilizar um laço para percorrer a string e verificar se o Character é isDigit(). Mas optei usar um regex para ficar mais claro

Prompt IA utilizado:
Request: qual é o regex utilizado para verificar dígitos de 0-9 em qualquer posição na string
Retorno: ".*\\d.*"

Utilizei esse regex para verificar se tem pelo menos um digito na string e verifico se o input não está null para não quebrar o regex



*LowercaseValidatorServiceImpl função isValid
Percorro a String através de um laço for, utilizo isLowerCase da classe Character para verificar cada posição da string se é caixa baixa se encontrar pelo menos uma vez já da um return e sai do laço




*UppercaseValidatorServiceImpl função isValid
Percorro a String através de um laço for, utilizo isUpperCase da classe Character para verificar cada posição da string se é caixa alta se encontrar pelo menos uma vez já da um return e sai do laço


Commit: feat: Implementação da logica dos métodos validadores e separação dos pacotes por responsabilidade
Branch: feature/validator-methods



