
# MicroShop

MicroShop é um sistema distribuído composto por 5 microserviços independentes, desenvolvido em Java utilizando o framework Spring. O projeto foi projetado para suportar cargas distribuídas em um ambiente de orquestração de containers com Kubernetes, com comunicação assíncrona via RabbitMQ e persistência temporária usando Redis.

## Índice
- [Descrição](#descrição)
- [Arquitetura](#arquitetura)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Estrutura dos Microserviços](#estrutura-dos-microserviços)

## Descrição
MicroShop é uma aplicação projetada para operações de e-commerce, englobando funcionalidades como gerenciamento de catálogo, checkout de compras, controle de ordens de serviço e processamento de pagamentos. A arquitetura moderna baseada em microserviços oferece escalabilidade e resiliência, utilizando práticas de DevOps para automação e gestão de infraestrutura.

## Arquitetura
- **Microserviços**: 5 aplicações independentes que comunicam entre si de forma assíncrona.
- **Mensageria**: RabbitMQ é utilizado para comunicação e processamento de mensagens.
- **Banco de Dados**: Redis é utilizado como armazenamento de dados temporário/cache.
- **Orquestração**: Kubernetes gerencia o ciclo de vida dos containers, garantindo alta disponibilidade e balanceamento de carga.

## Tecnologias Utilizadas
- **Java** e **Spring Boot**: Desenvolvimento dos microserviços.
- **Docker**: Containerização das aplicações.
- **Kubernetes**: Orquestração de containers em um cluster.
- **RabbitMQ**: Comunicação assíncrona entre microserviços.
- **Redis**: Armazenamento de dados em memória para alta performance.

## Pré-requisitos
- Docker
- Kubernetes (Minikube ou outro ambiente de cluster)
- RabbitMQ e Redis (executando como containers ou instalados no cluster)
- Java 17+
- Maven 3.8+

## Como Executar
1. **Clone o repositório:**
   \`\`\`bash
   git clone https://github.com/GabrielJacobina/MicroShop
   cd MicroShop
   \`\`\`

2. **Construir os microserviços:**
   \`\`\`bash
   mvn clean package
   \`\`\`

3. **Dockerizar as aplicações:**
   \`\`\`bash
   docker-compose build
   \`\`\`

4. **Subir os serviços locais com Docker Compose (opcional para testes locais):**
   \`\`\`bash
   docker-compose up
   \`\`\`

5. **Implantar no Kubernetes:**
    - Verifique se o cluster Kubernetes está configurado e em execução.
    - Aplique os manifests Kubernetes:
      \`\`\`bash
      kubectl apply -f k8s/
      \`\`\`

6. **Verificar os pods e serviços em execução:**
   \`\`\`bash
   kubectl get pods
   kubectl get services
   \`\`\`

## Estrutura dos Microserviços
1. **Catalog Service**: Gerencia produtos e categorias.
2. **Order Service**: Processa ordens de compra.
3. **Payment Service**: Gerencia pagamentos.
4. **Checkout Service**: Orquestra o processo de checkout.
5. **Product Service**: Lida com operações relacionadas a produtos.

Cada serviço possui suas próprias configurações e documentação detalhada no respectivo diretório.

## Comunicação e Mensageria
- RabbitMQ é configurado para filas que processam mensagens de forma assíncrona, garantindo que os serviços não fiquem bloqueados em operações demoradas.

## Persistência e Cache
- Redis é usado para armazenamento em cache, melhorando o desempenho e o tempo de resposta da aplicação.




