DESCRIPTION = "Docker container to generate epub's from doc"
SECTION = "service/epub"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

require conf/local-data.inc

SRC_URI = "${LOCALURI}/epubd.tar.gz;unpack=0"

do_install() {
    install -d -m 0755 ${D}/opt
    install ${LOCAL_ABSPATH}/epubd.tar.gz ${D}/opt/
}

FILES_${PN} += " /opt "

pkg_postinst_${PN}() {
    if [ "x$D" = "x" ]; then
        zcat /opt/epubd.tar.gz | docker load
        docker run --name epub-service --restart=always -p 4080:8000 epubd /home/epubgen/run.bash
    else
        exit 1
    fi
}
