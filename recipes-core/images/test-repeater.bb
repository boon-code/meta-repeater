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
        wifi-wl0084e \
        openssh-sshd \
        openssh-ssh \
        openssh-sftp-server \
        openssh-scp \
        tmux \
        kmod \
        python3 \
        python3-pip \
        dnsmasq \
        wireless-tools \
        iw \
        hostapd \
        connman \
        connman-client \
        vim \
        bash \
        bash-completion \
        go-helloworld \
        user-pi \
        usbutils \
        docker \
        ldd \
        crda \
        wireless-regdb \
"

IMAGE_INSTALL_append := " \
        htop \
        gcc \ 
        gdb \
        git \
        git-perltools \
        strace \ 
        picocom \
        iperf \ 
        iperf3 \
        netcat \
        socat \ 
"

# file system utilities
IMAGE_INSTALL_append := " \
        dosfstools \
        e2fsprogs-e2fsck \
        e2fsprogs-resize2fs \
        e2fsprogs-mke2fs \
        e2fsprogs-tune2fs \
        f2fs-tools \
        yaffs2-utils \
        logfsprogs \
        nfs-utils \
"

IMAGE_FEATURES_append := " package-management tools-profile"
