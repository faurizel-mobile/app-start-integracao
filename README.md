# StartApp

Aplicativo Android desenvolvido em Kotlin para demonstrar a navegação entre telas básicas de login, cadastro e área de seguros.

## Objetivo

Este projeto foi pensado como material didático para aulas de desenvolvimento mobile com Android/Kotlin. O foco é ensinar:

- criação de layouts em XML
- ligação entre layout e Activity
- uso de `Intent` para navegação entre telas
- validação simples de campos de formulário
- estrutura básica de um projeto Android

## Visão geral do app

O app possui 3 telas principais:

1. Tela de Login
2. Tela de Cadastro
3. Tela de Seguros

Fluxo principal:

- Usuário informa e-mail e senha na tela de login
- Se os campos estiverem vazios, aparece uma mensagem de alerta
- Se os campos forem preenchidos, abre a tela de seguros
- O botão "Cadastrar" abre a tela de cadastro

## Estrutura do projeto

```text
app-start-integracao/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── br/gov/sp/startapp/
│   │   │   │       ├── MainActivity.kt
│   │   │   │       ├── CadastroUsuuarioActivity.kt
│   │   │   │       └── SeguroActivity.kt
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       │   ├── activity_main.xml
│   │   │       │   ├── activity_cadastro_usuuario.xml
│   │   │       │   └── activity_seguro.xml
│   │   │       └── values/
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
└── README.md
```

## Mockup do app

### 1) Tela de Login

```text
+--------------------------------------------------+
|                START APP                         |
|                                                  |
|  Login                                           |
|                                                  |
|  E-mail: [___________________________]           |
|  Senha:  [___________________________]           |
|                                                  |
|  [ Logar ]    [ Cadastrar ]                     |
|                                                  |
+--------------------------------------------------+
```

### 2) Tela de Cadastro

```text
+--------------------------------------------------+
|                CADASTRO USUÁRIO                  |
|                                                  |
|  Nome completo: [____________________________]    |
|  E-mail:        [____________________________]    |
|  Senha:          [____________________________]    |
|                                                  |
|                [ Cadastrar ]                     |
|                                                  |
+--------------------------------------------------+
```

### 3) Tela de Seguros

```text
+--------------------------------------------------+
|                 SEGUROS XPTO                     |
|                                                  |
|                Serviços                          |
|  [ Automóveis ]   [ Imóveis ]                   |
|                                                  |
|                Novidades                         |
|                                                  |
+--------------------------------------------------+
```

## Procedimento didático para a aula

### Passo 1: Preparação do ambiente

1. Abra o Android Studio.
2. Crie um novo projeto Android com:
   - Nome: `StartApp`
   - Linguagem: Kotlin
   - Empty Activity
3. Configure o pacote com nome semelhante a:
   - `br.gov.sp.startapp`
4. Aguarde o Gradle sincronizar o projeto.

### Passo 2: Entendendo a estrutura inicial

Explique aos alunos que o Android tem a seguinte divisão básica:

- `MainActivity.kt`: responsável pela lógica principal da tela inicial
- `activity_main.xml`: responsável pela interface visual da tela
- `AndroidManifest.xml`: registra as Activities e define a Activity inicial

Destaque que cada tela do app é uma `Activity` e cada Activity geralmente tem um layout associado.

### Passo 3: Criar a tela de login

No arquivo `activity_main.xml`, adicione:

- um `TextView` para o título "Login"
- dois `EditText` para e-mail e senha
- dois `Button` para "Logar" e "Cadastrar"

Exemplo de estrutura visual:

```xml
<LinearLayout
    android:orientation="vertical"
    ...>

    <TextView
        android:text="Login" />

    <EditText
        android:id="@+id/editTextEmail"
        android:hint="E-mail" />

    <EditText
        android:id="@+id/editTextSenha"
        android:hint="Senha" />

    <Button
        android:id="@+id/buttonLogar"
        android:text="Logar" />

    <Button
        android:id="@+id/buttonCadastrar"
        android:text="Cadastrar" />

</LinearLayout>
```

### Passo 4: Registrar os elementos na Activity

No `MainActivity.kt`, faça a leitura dos componentes do layout com `findViewById`:

```kotlin
val email = findViewById<EditText>(R.id.editTextEmail)
val senha = findViewById<EditText>(R.id.editTextSenha)
val btnLogar = findViewById<Button>(R.id.buttonLogar)
val btnCadastrar = findViewById<Button>(R.id.buttonCadastrar)
```

Explique que este código conecta a parte Java/Kotlin com o XML da interface.

### Passo 5: Validar campos da tela inicial

Adicione a lógica de clique do botão `Logar`:

```kotlin
btnLogar.setOnClickListener {
    if (email.text.isEmpty() || senha.text.isEmpty()) {
        Toast.makeText(this, "E-mail ou senha vazio", Toast.LENGTH_LONG).show()
    } else {
        val intent = Intent(this, SeguroActivity::class.java)
        startActivity(intent)
    }
}
```

Objetivo da explicação:

- `isEmpty()` verifica se o campo está em branco
- `Toast` mostra uma mensagem ao usuário
- `Intent` navega para outra Activity

### Passo 6: Navegar para a tela de cadastro

Adicione a ação do botão de cadastro:

```kotlin
btnCadastrar.setOnClickListener {
    val intent = Intent(this, CadastroUsuuarioActivity::class.java)
    startActivity(intent)
}
```

Explicar que `Intent` serve como ponte entre telas.

### Passo 7: Criar a tela de cadastro

Crie a Activity `CadastroUsuuarioActivity.kt` e o layout `activity_cadastro_usuuario.xml`.

No layout, adicione:

- `TextView` com o título "Cadastro Usuario"
- `EditText` para nome completo
- `EditText` para e-mail
- `EditText` para senha
- `Button` para cadastrar

### Passo 8: Criar a tela de seguros

Crie a Activity `SeguroActivity.kt` e o layout `activity_seguro.xml`.

Adicione:

- título: `Seguros XPTO`
- seção: `Serviços`
- opções visuais: `Automóveis` e `Imóveis`
- seção: `Novidades`

Essa tela representa uma área interna do aplicativo após login.

### Passo 9: Registrar as Activities no AndroidManifest

No arquivo `AndroidManifest.xml`, cada Activity precisa ser declarada.

Exemplo:

```xml
<activity
    android:name=".MainActivity"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>

<activity
    android:name=".CadastroUsuuarioActivity"
    android:exported="false" />

<activity
    android:name=".SeguroActivity"
    android:exported="false" />
```

### Passo 10: Executar e testar o app

1. Conecte um emulador Android ou dispositivo físico
2. Clique em "Run"
3. Teste:
   - login vazio
   - clique em "Cadastrar"
   - clique em "Logar" com dados preenchidos
   - navegação entre telas

## Lógica de navegação do projeto

O fluxo principal do app é:

```text
MainActivity
   ├── Botão Logar → SeguroActivity
   └── Botão Cadastrar → CadastroUsuuarioActivity
```

## Resultado esperado

Ao final da aula, os alunos devem ser capazes de:

- criar telas simples em Android
- entender a relação entre XML e Kotlin
- fazer navegação com `Intent`
- validar campos de entrada
- montar um fluxo básico de autenticação e cadastro

## Observações para a aula

- Este projeto é uma versão simples e didática, sem banco de dados
- A navegação é local, não persistente
- Pode ser ampliado com:
  - cadastro em SharedPreferences
  - validação de e-mail
  - senha escondida
  - listas de seguros dinamicamente

## Como executar

No terminal, na raiz do projeto:

```bash
./gradlew assembleDebug
```

Ou abra o projeto no Android Studio e clique em "Run".

## Conclusão

Este app funciona como uma introdução prática ao desenvolvimento Android com Kotlin, ajudando o aluno a visualizar como uma aplicação móvel organiza telas, navegação e interação com o usuário.

---

Projeto desenvolvido para fins didáticos.
