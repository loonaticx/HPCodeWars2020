Welcome to Virtual CodeWars 2020!

This ZIP file includes:

- README.txt:
    This file.

- CodeWars_2020_All_Problems.pdf:
    Instruction sheet and Problems 0-30

    NOTE:  In the On-site competition, Problems 0 and 1 can be submitted early.
           FOR THIS VIRTUAL EVENT, you will submit ALL solutions in a single ZIP file.
           DO NOT SEND SOLUTIONS TO PROBLEMS 0 AND 1 SEPARATELY.

- student_datasets:
    Directory with test data for every problem.
    Use each input to test your program, and compare with each expected output.

- ringojs-1.2.0:
    Support directory for checkProb.bat.  Only needed if testing JavaScript.

- checkProb.bat:
    A Windows batch file like the one the Judges will use to test your programs.

    HOW TO USE:
        1. EDIT THE FILE to set your JDK and/or PYTHON paths.
            - You need JDKPATH if you are using Java or JavaScript.
            - You need PY3PATH or PY2PATH if you are using Python 3 or 2.

        2. COPY only one program "probXX.zzz" into the directory.  (For example, "prob10.py")
            - NOTE: A Python2 program must have its file extension changed to "py2"

        3. Open a Command Window  (Start Menu: "Command Prompt")
            - CD to your working directory.

        4. Type "checkProb" to test your program against all probXX datasets in the student_datasets directory.
            - Use "checkProb showin" to also show the test input during the run

    NOTE:  Using checkProb.bat is OPTIONAL.
        We provide it as an example of how we will be testing your programs.
        You do not need it.  But you must test your program against ALL input files.
        The Judges will test against modified input files, and your programs
        must correctly solve all of them to pass.
        See an explanation of how to test on the Instruction Sheet in the PDF file.
