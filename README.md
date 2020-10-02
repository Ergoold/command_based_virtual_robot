# Virtual Robot Command Based
Implements a command based library on top of the FTC virtual robot program.
Theoretically, this can also be used in actual java FTC programming by taking only the `CommandBased` module (found in the directory of the same name).

## Command Based Programming
Command-based programming is a model used for a long time in FRC programming.

You create subsystems and commands that operate on them, and use these in your op modes instead of activating hardware directly.
This helps separate your code into different classes for the different parts of your robot and the actions they can perform.

This repository also contains the recomended project structure for FTC command based robots, in the `org.firstinspires.ftc.teamcode` inside the `TeamCode` module.

For more details on FTC robot programming and the virtual robot program, see [Beta8397/virtual_robot](https://github.com/Beta8397/virtual_robot).
