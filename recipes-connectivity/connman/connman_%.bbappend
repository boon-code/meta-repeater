FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://main.conf"

PR := "r2"

do_configure_prepend() {
    # Prevent overriding symlink from systemd-resolved
    sed -i '/^L.*\/etc\/resolv.conf.*$/d' ${S}/scripts/connman_resolvconf.conf.in
}

do_install_prepend() {
    install -D -m 0755 ${WORKDIR}/main.conf ${D}${sysconfdir}/connman/main.conf
}

do_install_append() {
    # Don't use built-in DNS proxy as systemd-resolved will already be used
    sed -i '/ExecStart=\/usr\/sbin\/connmand/ s/$/ --nodnsproxy/' ${D}${systemd_system_unitdir}/connman.service
}
