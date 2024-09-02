# Sistema de Reservas de Academia
## Descrição
Este projeto consiste no desenvolvimento de um sistema backend para gerenciar reservas de uma academia doméstica. <br>
O sistema permite aos usuários criar, listar e deletar reservas de horários para uso da academia, respeitando restrições de horário e disponibilidade. <br>
O projeto foi desenvolvido em Java utilizando o framework Spring Boot e se integra com um banco de dados MySQL. <br>

## Funcionalidades
**Criação de Reservas:** Os usuários podem criar reservas para usar a academia, com validações que garantem que as reservas sejam feitas apenas entre 06h00 e 22h00, sem conflitos de horários. <br>
**Listagem de Reservas:** Exibe todas as reservas cadastradas no sistema. <br>
**Deleção de Reservas:** Permite a remoção de reservas por ID. <br>
**Validações de Negócio:** Impede reservas no passado e fora do horário permitido. <br>

## Tecnologias Utilizadas
Java 11+ <br>
Spring Boot <br>
Spring Data JPA <br>
MySQL <br>
JUnit (para testes unitários) <br>
Maven (para gerenciamento de dependências) <br>

## Estrutura do Projeto
**Controller:** Responsável por gerenciar as requisições HTTP e encaminhá-las para a camada de serviço. <br>
**Service:** Contém a lógica de negócios e validações. <br>
**Repository:** Responsável pela comunicação com o banco de dados. <br>
**Entities:** Define as entidades do sistema, como Reserva. <br>

## Pré-requisitos
Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina: <br>

Java 11 ou superior <br>
Maven <br>
MySQL <br>
