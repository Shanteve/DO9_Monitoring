#!/bin/bash
set -e

echo "Инициализация Docker Swarm"
docker swarm init --advertise-addr 192.168.56.10

echo "Сохранение токена для worker'ов"
docker swarm join-token worker -q > /home/vagrant/src/swarm_token.txt