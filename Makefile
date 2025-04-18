run-dist:
	./app/build/install/app/bin/app
clean:
	make -C ./app clean
build:
	make -C ./app build
installDist:
	make -C ./app installDist
run:
	make -C ./app run
check:
	make -C ./app check