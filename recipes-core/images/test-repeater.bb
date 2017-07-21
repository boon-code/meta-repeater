DESCRIPTION = "Draft image to build a WLan repeater based on RPI"

# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

inherit extrausers

# Generated using following command:
# python3 -c 'import sys;import crypt; import getpass;print(crypt.crypt(getpass.getpass("Password: ", sys.stderr)).replace("$", "\\$"))'
ROOT_PASSWORD ?= "\$6\$jSC9SPiKanwKQr8h\$2h6UuDWXgZ25JhzIJKYQw.Zl2qxTrViObKYKl86PQTkxw1Y2/7ZY6avkUSQtiRWKmUZsEgDfBwNj4vcr/Soks/"

EXTRA_USERS_PARAMS := "usermod -p '${ROOT_PASSWORD}' root;"

# Full command-line tools
IMAGE_INSTALL_append := " \
        packagegroup-core-buildessential \
        packagegroup-core-full-cmdline \
"

IMAGE_INSTALL_append := " \
        kernel-modules \
        openssh-sshd \
        openssh-ssh \
        openssh-sftp-server \
        openssh-scp \
        tmux \
        kmod \
        vim \
        bash \
        bash-completion \
        user-pi \
        usbutils \
        ldd \
        iw \
        hostapd \
        connman \
        connman-client \
        crda \
        wireless-regdb \
        wireless-tools \
        linux-firmware-bcm43430 \
        linux-firmware-ralink \
        perl \
        curl \
        openssl \
        openssl-misc \
        tcpdump \
"

IMAGE_INSTALL_append := " \
        packagegroup-build-host \
"

IMAGE_INSTALL_append := " \
        mpd \
        ffmpeg \
"

IMAGE_INSTALL_append := " \
        htop \
        gcc \ 
        cmake \
        gdb \
        git \
        git-perltools \
        strace \ 
        minicom \
        iperf3 \
        netcat \
        socat \ 
        i2c-tools \
"

IMAGE_INSTALL_append := " \
        python3 \
        python3-modules \
        python3-pip \
        python3-multiprocessing \
        python3-asyncio \
        python3-io \
"

IMAGE_INSTALL_append := " \
        python3-shopbot \
"

# file system utilities
IMAGE_INSTALL_append := " \
        dosfstools \
        e2fsprogs-e2fsck \
        e2fsprogs-resize2fs \
        e2fsprogs-mke2fs \
        e2fsprogs-tune2fs \
        nfs-utils \
        btrfs-tools \
"

IMAGE_FEATURES_append := " package-management tools-profile"
