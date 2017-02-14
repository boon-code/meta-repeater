FILESEXTRAPATHS_prepend := "${THISDIR}/systemd:"

SRC_URI += "file://01-eth.network \
            file://02-wifi.network \
            file://journald.conf \
"

do_install_append() {
    for i in "01-eth.network" "02-wifi.network"; do
        install -m 0644 -D "${WORKDIR}/$i" "${D}${systemd_unitdir}/network/$i"
    done
    install -m 0644 -D "${WORKDIR}/journald.conf" "${D}${systemd_unitdir}/journald.conf"
}
