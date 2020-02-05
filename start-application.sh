#!/usr/bin/env bash


echo "CASHBACK API BEBLUE V-0.0.1"
echo "Projeto em: Spring Framework"
echo "Autor: Hugo Gois Santos"
echo "Projeto de uma API REST em Java (Spring Framework)."



echo "Inicializando container..."

sudo docker build -f application/Dockerfile -t gudshugo/cashback-api . && sudo docker run -d -p 80:80 --network host --name cashback-api gudshugo/cashback-api

echo "Aplicação online..."
