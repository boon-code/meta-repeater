DESCRIPTION = "Prepared image for our home raspberry PI"

require test-image.inc

IMAGE_INSTALL_append = " \
    connman-config \
    shopbot-config \
    epubd \
    irpoll \
"
