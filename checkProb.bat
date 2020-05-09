@echo off
REM ***********************************************************************
REM
REM   CODEWARS
REM
REM   Judging Batch File
REM
REM   NOTES:
REM
REM *  IMPORTANT: Check path to Java JDK environment and Python
REM        set JDKPATH below
REM        set PY3PATH and/or PY2PATH below
REM *  Expects data in local student_datasets subdirectory
REM *  Will work up with problems 0-30
REM     *  Will work with .java, .js, .py, .py2, .py3, and .exe file types
REM
REM ***********************************************************************


REM
REM  These are paths to the language interpreters / SDK
REM
SET JDKPATH="C:\Program Files\Java\jdk1.8.0_161\bin"
SET PY3PATH=C:\Python36
SET PY2PATH=C:\Python27
SET PYPATH=%PY3PATH%
REM  Python2 path will be chosen if a .py2 file is present
REM  Using the ringo run.jar to run JavaScript.
SET RINGOJARPATH=ringojs-1.2.0\run.jar

SET SHOWIN=0

REM
REM Analyze optional parameters
REM
IF "%1"=="" GOTO START_JUDGE
IF /I "%1"=="SHOWIN" SET SHOWIN=1
IF %SHOWIN%==1 GOTO START_JUDGE
REM For any other parameter, show the Help Screen
GOTO HELP

:START_JUDGE
REM
REM Determine problem number from files in current directory
REM

Set num=99
Set pass=1
if EXIST prob00*.* SET num=00
if EXIST prob01*.* SET num=01
if EXIST prob02*.* SET num=02
if EXIST prob03*.* SET num=03
if EXIST prob04*.* SET num=04
if EXIST prob05*.* SET num=05
if EXIST prob06*.* SET num=06
if EXIST prob07*.* SET num=07
if EXIST prob08*.* SET num=08
if EXIST prob09*.* SET num=09
if EXIST prob10*.* SET num=10
if EXIST prob11*.* SET num=11
if EXIST prob12*.* SET num=12
if EXIST prob13*.* SET num=13
if EXIST prob14*.* SET num=14
if EXIST prob15*.* SET num=15
if EXIST prob16*.* SET num=16
if EXIST prob17*.* SET num=17
if EXIST prob18*.* SET num=18
if EXIST prob19*.* SET num=19
if EXIST prob20*.* SET num=20
if EXIST prob21*.* SET num=21
if EXIST prob22*.* SET num=22
if EXIST prob23*.* SET num=23
if EXIST prob24*.* SET num=24
if EXIST prob25*.* SET num=25
if EXIST prob26*.* SET num=26
if EXIST prob27*.* SET num=27
if EXIST prob28*.* SET num=28
if EXIST prob29*.* SET num=29
if EXIST prob30*.* SET num=30

if %num%==99 GOTO HELP

REM
REM Set the name of the datafile
SET DATAFILE=student_datasets\prob%num%-

GOTO COPY

:HELP
echo.
echo    CodeWars Judging Batch file
echo    ---------------------------
echo.
echo     Usage:  checkProb [SHOWIN]
echo             File probXX.* must exist in the current directory.
echo             Only one file probXX.* may exist.
echo.
echo       The problem number (00-30) is determined from probXX.* filename
echo       SHOWIN: Show the input file
echo.
GOTO ENDJUDGE


:COPY
REM
REM Select Python2 path for a .py2 file
if EXIST *.py2  SET PYPATH=%PY2PATH%
REM Rename python files to .py now that we have the correct PYPATH set
if EXIST *.py3  copy prob%num%.py3 prob%num%.py > NUL
if EXIST *.py2  copy prob%num%.py2 prob%num%.py > NUL

echo -------------------------------------------------------------------------------
echo     ************ CODEWARS Judging : Problem #%num% ****************
echo -------------------------------------------------------------------------------
echo.

if EXIST prob%num%.java GOTO JAVA

if EXIST prob%num%.js GOTO Judge

if EXIST prob%num%.py GOTO Judge

if EXIST prob%num%.exe GOTO Judge

ECHO **** ERROR:  No Valid submission file format found for Problem #%num%
GOTO DONE


:JAVA
REM
REM     Compile the java program from source code
REM

if EXIST prob%num%.java GOTO Compile

echo ******* ERROR:  NO .java called prob%num% ********
GOTO Done

:Compile
echo Compiling Class file from Java Source  ...
echo.
%JDKPATH%\javac prob%num%.java

if EXIST prob%num%.class GOTO Judge
echo
echo ******* ERROR:  .java source did not compile for prob%num%     ********
echo *******  Does JDKPATH point to your JDK directory?             ********
echo *******  Does your main class match your filename: prob%num% ? ********
GOTO Done

:Judge
cls

echo Input data filename is %DATAFILE%%pass%-in.txt
copy %DATAFILE%%pass%-in.txt input.txt > NUL
if %SHOWIN%==1 type input.txt

echo.
echo -------------------------------------------------------------------------------
echo -- Problem #%num%, pass #%pass% .  Program output begins ----------------------
echo -------------------------------------------------------------------------------
echo.

if EXIST prob%num%.class %JDKPATH%\java -cp . prob%num% < input.txt
if EXIST prob%num%.js %JDKPATH%\java -cp . -jar %RINGOJARPATH% prob%num%.js < input.txt
if EXIST prob%num%.py %PYPATH%\python prob%num%.py < input.txt
if EXIST prob%num%.exe prob%num% < input.txt

echo.
echo -------------------------------------------------------------------------------
echo -- Compare to EXPECTED Output Below -------------------------------------------
echo -------------------------------------------------------------------------------
echo.
type %DATAFILE%%pass%-out.txt
echo.

REM
REM     Perform test with next dataset (if it exists)
REM

if %pass% == 8 SET pass=99
if %pass% == 7 SET pass=8
if %pass% == 6 SET pass=7
if %pass% == 5 SET pass=6
if %pass% == 4 SET pass=5
if %pass% == 3 SET pass=4
if %pass% == 2 SET pass=3
if %pass% == 1 SET pass=2

if NOT EXIST %DATAFILE%%pass%-in.txt GOTO DONE

echo.
echo ------------------ Press Any key to Run next dataset ------------------------
echo.
pause
GOTO JUDGE


:Done

echo.
echo -------------------------------------------------------------------------------
echo -- JUDGING COMPLETE -----------------------------------------------------------
echo -------------------------------------------------------------------------------
echo.
pause
echo -------------------------------------------------------------------------------
echo -- Removing temporary files   -------------------------------------------------
echo -------------------------------------------------------------------------------
if EXIST *.class del *.class > NUL
if EXIST *.jar del *.jar > NUL
if EXIST input.txt del input.txt > NUL

:ENDJUDGE
