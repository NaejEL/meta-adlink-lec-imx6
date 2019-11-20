IMAGE_INSTALL_append = " ${@bb.utils.contains("MACHINE_FEATURES", "sema", "semagui", "", d)}"
