@echo OFF


rem user = args[0] = "docathouse" 
rem domain = args[1]= "45.113.136.152"
rem password =args[2]="e2y2agumu" 
rem inputfile =args[3]= your  required file path 
rem  outputfilepath=args[4] = your output file path=/home/docathouse/msacess/

set uname="docathouse"
set domain="45.113.136.152"
set password="e2y2agumu"
set inputfile="C:/Users/SudhanshuLenka/Downloads/ontime_att-new.mdb"
set serverfilepath="/home/docathouse/msacess/"


java  -jar logicq.jar %uname% %password% %domain% %inputfile% %serverfilepath%