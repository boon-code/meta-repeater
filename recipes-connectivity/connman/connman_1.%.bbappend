FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://main.conf"

PR := "r2"

do_install_prepend() {
    install -D -m 0755 ${WORKDIR}/main.conf ${D}${sysconfdir}/connman/main.conf
}
