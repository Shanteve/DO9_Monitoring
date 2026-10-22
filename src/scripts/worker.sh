#!/bin/bash
set -e

echo "Ожидание файла с swarm-токеном"
while [ ! -f /home/vagrant/src/swarm_token.txt ]; do
    sleep 1;
done
docker swarm join --token $(cat /home/vagrant/src/swarm_token.txt) 192.168.56.10
echo "Worker нода успешно подключена!"