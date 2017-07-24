#!/bin/sh

IMAGE=/opt/epubd.tar.gz
VARDIR=/var/lib/epub

if [ ! -e "$IMAGE" ]; then
    echo "ERROR: Image '$IMAGE' is missing" >&2
    exit 1
fi

echo "DEBUG: Start loading docker image from /opt"
zcat /opt/epubd.tar.gz | docker load

id="$(docker ps -f Name=epub-service --format {{.ID}})"
if [ -z "$id" ]; then
    echo "DEBUG: Create and start a new container"
    docker run --detach --name epub-service --restart=always -p 4080:8000 epubd /home/epubgen/run.bash
    ret=$?
    if [ $ret -eq 0 ]; then
        echo "DEBUG: Starting epub-service succeeded"
    else
        echo "ERROR: docker run failed: $ret"
        exit 1
    fi
else
    echo "DEBUG: Container id=$id is already running -> skipping"
fi

echo "DEBUG: Marking job as done"
mkdir -p $VARDIR
touch $VARDIR/install.done
echo "DEBUG: Installation succeeded"
