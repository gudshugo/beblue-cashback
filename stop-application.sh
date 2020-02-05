#!/usr/bin/env bash


echo "CASHBACK API BEBLUE V-0.0.1"
echo "Projeto em: Spring Framework"
echo "Autor: Hugo Gois Santos"
echo "Projeto de uma API REST em Java (Spring Framework)."



echo "Derrubando container..."
sudo docker stop cashback-api
sudo docker rm cashback-api

echo "Aplicação offline..."
