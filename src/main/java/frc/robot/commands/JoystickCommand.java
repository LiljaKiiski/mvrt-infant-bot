// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class JoystickCommand extends CommandBase {
  private Supplier<Double> frontBackAxis;
  private Supplier<Double> rightLeftAxis;

  private Drivetrain drivetrain;

  private final double THRESH;

  /** Creates a new JoystickCommand. */
  public JoystickCommand(Drivetrain drivetrain, Supplier<Double> frontBackAxis, Supplier<Double> rightLeftAxis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.frontBackAxis = frontBackAxis;
    this.rightLeftAxis = rightLeftAxis;
    THRESH = 0.1;

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double frontBack = frontBackAxis.get();
    double rightLeft = rightLeftAxis.get();

    //Forward
    if (frontBack > THRESH){
      drivetrain.forward();
    }

    //Backward
    if (frontBack < -THRESH){
      drivetrain.backward();
    }

     //Right
     if (rightLeft > THRESH){
      drivetrain.right();
    }

    //Left
    if (rightLeft < -THRESH){
      drivetrain.left();
    }

    //Stop
    if (Math.abs(frontBack) <= THRESH && Math.abs(rightLeft) <= THRESH){
      drivetrain.stop(); 
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
