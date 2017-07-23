DESCRIPTION = "Main user for Raspberry PI"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR := "r14"

inherit useradd

# Generated using following command:
# python3 -c 'import sys;import crypt; import getpass;print(crypt.crypt(getpass.getpass("Password: ", sys.stderr)).replace("$", "\\$"))'
USR_PASSWORD ?= "\$6\$fTeCH9TndeyGSHKw\$ui/hoIik9XB.nLsEJNt/AxESjNa7op37isl/gbmv.9rLqPmscqQ6FBEkeAOGf8f9zRcKzCZRf1.0UmUIZ0CSr0"

USR_NAME := "pi"
USR_HOME := "/home/${USR_NAME}"

PACKAGES = "${PN}"
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} := "-u 1003 -d ${USR_HOME} -r -s /bin/bash -p '${USR_PASSWORD}' ${USR_NAME}"
GROUPADD_PARAM_${PN} = "users"

do_install() {
    install -d -m 0755 ${D}${USR_HOME}
    chown -R ${USR_NAME} ${D}/${USR_HOME}
    chgrp -R users ${D}/${USR_HOME}
}

FILES_${PN} += " \
        ${USR_HOME} \
"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
