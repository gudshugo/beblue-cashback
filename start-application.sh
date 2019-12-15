#!/usr/bin/env bash


echo "CASHBACK API BEBLUE V-0.0.1"
echo "Projeto em: Spring Framework"
echo "Autor: Hugo Gois Santos"
echo "Projeto de uma API REST em Java (Spring Framework) referente ao teste técnico para desenvolvedor java na Fintech Beblue."



echo "Inicializando docker-compose..."
sudo docker-compose -f docker-compose.yml up --build -d;


echo "Finalizado o deploy da aplicação..."
