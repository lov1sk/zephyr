# Zephyr - Um provider para envio de emails

Essa aplicação tem como objetivo ser um serviço
que pode ser chamado para enviar diversos tipos de emails
usando a infra da Amazon SES.

É importante salientar que esse projeto foi baseado na aplicação
da Fernanda Kipper,o qual ela constroi atraves do video: https://www.youtube.com/watch?v=eFgeO9M9lLw&t=2755s

## Instalação

1. Clone o repositorio:

```bash
  git clone https://github.com/Fernanda-Kipper/desafio-backend-uber.git
```

2. Instale as dependencias com o Maven.
3. Atualize o arquivo `application.properties` colocando suas credenciais AWS.

```bash
  aws.region=us-east-1
  aws.accessKeyId=1111111
  aws.secretKey=111111
```

## Uso da API

1.  Rodar a aplicação com o maven.
2.  Realizar requisições a API usando o endereço base http://localhost:8080/"endpoint"

## Endpoints

A aplicação provê os seguintes endpoints:

### GET EMAIL

```bash
  POST /app/mail - Envia um e-mail para um destinatário com base em uma mensagem, um assunto e o endereço de email do destinatário
```

### BODY

```json
{
  "to": "liveskipperdev@gmail.com",
  "subject": "teste",
  "body": "teste"
}
```
