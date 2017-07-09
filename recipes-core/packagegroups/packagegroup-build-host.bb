SUMMARY = "Build host"
DESCRIPTION = "Allow bitbake builds on target"

inherit packagegroup

PACKAGES =+ " packagegroup-build-host-tools packagegroup-build-host-extended packagegroup-build-host-sdk packagegroup-build-host-debug "

RDEPENDS_packagegroup-build-host = " \
        packagegroup-build-host-sdk \
        packagegroup-build-host-extended \
        packagegroup-build-host-debug \
        packagegroup-build-host-tools \
"

RDEPENDS_packagegroup-build-host-tools = " \
        e2fsprogs \
        e2fsprogs-e2fsck \
        e2fsprogs-mke2fs \
        e2fsprogs-tune2fs \
        hdparm \
        iptables \
        lsb \
        mc \
        mc-fish \
        mc-helpers \
        mc-helpers-perl \
        mc-helpers-python \
        parted \
        pseudo \
        tmux \
"

RDEPENDS_packagegroup-build-host-sdk = " \
        autoconf \
        automake \
        binutils \
        binutils-symlinks \
        ccache \
        coreutils \
        cpp \
        cpp-symlinks \
        distcc \
        file \
        findutils \
        g++ \
        g++-symlinks \
        gcc \
        gcc-symlinks \
        intltool \
        ldd \
        less \
        libssp \
        libssp-dev \
        libssp-staticdev \
        libstdc++ \
        libstdc++-dev \
        libtool \
        make \
        mktemp \
        perl-module-re \
        perl-module-text-wrap \
        pkgconfig \
        quilt \
        sed \
        glibc-gconv-ibm850 \
        glibc-utils \
"

RDEPENDS_packagegroup-build-host-debug = " \
        gdb \
        gdbserver \
        rsync \
        strace \
        tcf-agent \
"

RDEPENDS_packagegroup-build-host-extended = " \
        bzip2 \
        chkconfig \
        chrpath \
        cpio \
        curl \
        diffstat \
        diffutils \
        elfutils \
        expat \
        gawk \
        gdbm \
        gettext \
        gettext-runtime \
        git \
        git-perltools \
        grep \
        groff \
        gzip \
        settings-daemon \
        libaio \
        libusb1 \
        libxml2 \
        lrzsz \
        lsof \
        lzo \
        man \
        man-pages \
        mdadm \
        minicom \
        mtools \
        ncurses \
        ncurses-terminfo-base \
        neon \
        nfs-utils \
        nfs-utils-client \
        openssl \
        openssh-sftp-server \
        opkg \
        opkg-utils \
        patch \
        perl \
        perl-dev \
        perl-modules \
        perl-pod \
        perl-misc \
        glibc-binary-localedata-en-us \
        glibc-binary-localedata-de-at \
        python \
        python-modules \
        python-git \
        python3 \
        python3-modules \
        python3-git \
        quota \
        readline \
        rpm \
        setserial \
        socat \
        subversion \
        sudo \
        sysstat \
        tar \
        tcl \
        texi2html \
        texinfo \
        unzip \
        usbutils \
        watchdog \
        wget \
        which \
        xinetd \
        zip \
        zlib \
        xz \
"
