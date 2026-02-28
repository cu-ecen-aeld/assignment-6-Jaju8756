# yocto-assignments-base
Base repository for AESD Yocto assignments

#References:
	https://docs.yoctoproject.org/brief-yoctoprojectqs/index.html#build-host-packages
	
	
#Steps for Assignment7 Part2:
* update the repository using git commands
* from A6 root dir: source poky/oe-init-build-env -> changes the directory to ../build
* devtool add scull /home/jaju/AESD/assignment-7-Jaju8756/ -> A& is gonna be the working dir of devtool
	NOTE: Starting bitbake server...
	INFO: Using source tree as build directory since that would be the default for this recipe
	INFO: Recipe /home/jaju/AESD/assignment-6-Jaju8756/build/workspace/recipes/scull/scull_git.bb has been automatically created; further editing may be required to make it fully functional

* Modify MakeFile to include only misc-modules scull
* from A6 root dir: source poky/oe-init-build-env -> current dir: ../build
* devtool build scull
* devtool finish scull ../meta-aesd
	Parsing of 886 .bb files complete (885 cached, 1 parsed). 1647 targets, 56 skipped, 0 masked, 0 errors.
	INFO: Adding new patch 0001-Makefile-update-for-building-misc-modules-and-scull.patch
	INFO: Updating recipe scull_git.bb
	INFO: Moving recipe file to /home/jaju/AESD/assignment-6-Jaju8756/meta-aesd/recipes-scull/scull
	INFO: Leaving source tree /home/jaju/AESD/assignment-7-Jaju8756 as-is; if you no longer need it then please delete it manually
* inside .bb: 
	EXTRA_OEMAKE:append:task-install = " -C ${STAGING_KERNEL_DIR} M=${S}/scull"
* create AESD/assignment-6-Jaju8756/meta-aesd/recipes-scull/scull/files/
* nano scull-init inside files
	write init script for scull
* chmod +x scull-init
* inside .bb:
	inherit module update-rc.d
	install .....
* from A6 root : source poky/oe-init-build-env
* bitbake scull
