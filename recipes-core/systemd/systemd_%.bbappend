FILESEXTRAPATHS_prepend := "${THISDIR}/systemd:"

SRC_URI += "file://01-eth.network \
            file://journald.conf \
"
PACKAGECONFIG_append = " networkd resolved gcrypt "

do_install_append() {
    install -m 0644 -D "${WORKDIR}/01-eth.network" "${D}${systemd_unitdir}/network/01-eth.network"
    install -m 0644 -D "${WORKDIR}/journald.conf" "${D}${systemd_unitdir}/journald.conf"
    sed -i '/q\s*\/var\/tmp\s*.*$/d' ${D}${nonarch_libdir}/tmpfiles.d/tmp.conf
}
