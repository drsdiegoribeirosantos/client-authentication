# Client Authentication

Projeto criado com [Spring Initializr](https://start.spring.io/)  
Versão: **Spring Boot 3.5.3**  
Java: **17**

---

## 📌 Commits iniciais

- **Commit:** `chore: setup inicial com Spring Boot 3.5.3, Java 17`  
- **Branch:** `feature/init`

---

## 📦 Dependências

Todas as dependências adicionadas no `pom.xml` foram extraídas do [Maven Repository](https://mvnrepository.com/).

---

## 📊 Health Check

Para monitorar a saúde da aplicação foi adicionado o **Spring Boot Actuator**.

**Endpoint de verificação de saúde:**

http://localhost:8080/client-authentication/actuator/health

---

## 🧠 Planejamento e estruturação (antes de implementação SOLID)

A ideia é aplicar os princípios do **SOLID**, separando responsabilidades nas classes e utilizando abstrações.

### Etapas:

1. Criar a **interface abstrata** `ValidatorService` com o método:
   ```java
   boolean isValid(String password);
Implementar uma classe Impl para cada validação:

CharacterSizeValidatorServiceImpl

LowercaseValidatorServiceImpl

NumericDigitValidatorServiceImpl

UppercaseValidatorServiceImpl

SpecialCharactersValidatorServiceImpl

Cada uma dessas implementações sobrescreve isValid() com @Override.

Criar a classe PasswordValidationServiceImpl para:

Chamar as implementações da ValidatorService.

Orquestrar todas as regras.

Criar a interface PasswordValidationService e injetar na AuthenticationController (camada de view).

Commit: feat: Estruturação do projeto pacotes e classes (distribuição das responsabilidades) sem implementação
Branch: feature/structure

🔧 Implementação dos métodos de validação

CharacterSizeValidatorServiceImpl#isValid()
Criada constante ALLOWED_SPECIAL_CHARACTERS com os caracteres permitidos.

Criada variável repeatedCharacters (lista) para:

Armazenar os caracteres que já foram utilizados.

Verificar se há repetição (caracteres repetidos invalidam a senha).

Converti Character para String para usar contains() nas verificações.

A variável validCharacters define se os caracteres são válidos.
O return ocorre após o laço, somente após todas as verificações.




CharacterSizeValidatorServiceImpl#isValid() (verificação de tamanho)
Primeira verificação: se a senha for null, retorna false de imediato.

Utilizado regex para remover espaços em branco: "\\s".

Após remoção, usa .length() para verificar se a senha tem tamanho suficiente.

Prompt IA utilizado:

Qual expressão regular para remover qualquer tipo de espaço
Resposta: "\\s"





NumericDigitValidatorServiceImpl#isValid()
Inicialmente, pensei em usar um laço com Character.isDigit().

Optei por regex para maior clareza: " .*\\d.* "

Prompt IA utilizado:

Qual é o regex utilizado para verificar dígitos de 0-9 em qualquer posição na string
Resposta: " .*\\d.* "

Também valido se o input não é null antes de aplicar o regex.




LowercaseValidatorServiceImpl#isValid()
Percorre a string com um laço for.

Usa Character.isLowerCase() para verificar se ao menos um caractere é minúsculo.

Retorna true assim que encontra o primeiro minúsculo.




UppercaseValidatorServiceImpl#isValid()
Percorre a string com um laço for.

Usa Character.isUpperCase() para verificar se ao menos um caractere é maiúsculo.

Retorna true assim que encontra o primeiro maiúsculo.

✅ Commit de implementação
Commit: feat: Implementação da lógica dos métodos validadores e separação dos pacotes por responsabilidade
Branch: feature/validator-methods


--

✅ Commit de formatação de README
Commit: feat: Formatação do README
Branch: feature/readme

Prompt IA utilizado:
Request: Formatar a estrutura do README mantendo o conteúdo sem alteração do original
Response: Estruturação do README neste commit acima

