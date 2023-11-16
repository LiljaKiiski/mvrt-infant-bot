// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private TalonFX rightMotor;
  private TalonFX leftMotor;

  private final double SPEED;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    rightMotor = new TalonFX(0);
    leftMotor = new TalonFX(1);

    leftMotor.setInverted(true);

    SPEED = 0.3;
  }

  public void forward(){
    rightMotor.set(ControlMode.PercentOutput, SPEED);
    leftMotor.set(ControlMode.PercentOutput, SPEED);
  }

  public void backward(){
    rightMotor.set(ControlMode.PercentOutput, -SPEED);
    leftMotor.set(ControlMode.PercentOutput, -SPEED);
  }

  public void right(){
    rightMotor.set(ControlMode.PercentOutput, -SPEED);
    leftMotor.set(ControlMode.PercentOutput, SPEED);
  }

  public void left(){
    rightMotor.set(ControlMode.PercentOutput, SPEED);
    leftMotor.set(ControlMode.PercentOutput, -SPEED);
  }

  public void stop(){
    rightMotor.set(ControlMode.PercentOutput, 0);
    leftMotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
