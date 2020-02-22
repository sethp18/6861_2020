/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {
  
  private WPI_TalonSRX m_leftFtrMotor = new WPI_TalonSRX(15);
  private WPI_TalonSRX m_leftRrMotor = new WPI_TalonSRX(14);

  private WPI_TalonSRX m_rightFrtMotor = new WPI_TalonSRX(0);
  private WPI_TalonSRX m_rightRrMotor = new WPI_TalonSRX(1);
    
  public XboxController m_driverController1 = new XboxController(0);

  private SpeedControllerGroup leftMtrGroup = new SpeedControllerGroup(m_leftFtrMotor,m_leftRrMotor);
  private SpeedControllerGroup rightMtrGroup = new SpeedControllerGroup(m_rightFrtMotor,m_rightRrMotor);

  private DifferentialDrive m_robotDrive = new DifferentialDrive(leftMtrGroup, rightMtrGroup);
  
  private double mtrSpeed = -0.7;

  public void driveTank() {
      m_leftFtrMotor.setNeutralMode(NeutralMode.Brake);
      m_rightFrtMotor.setNeutralMode(NeutralMode.Brake);
      m_leftRrMotor.setNeutralMode(NeutralMode.Brake);
      m_rightRrMotor.setNeutralMode(NeutralMode.Brake);

      m_robotDrive.tankDrive(Math.pow(m_driverController1.getY(Hand.kLeft),3)*mtrSpeed,
      Math.pow(m_driverController1.getY(Hand.kRight),3)*mtrSpeed);
  }
  public void driveAuton(final double speed, int i) {
    for(i = 0; i <= 10000; i++)
    {
        m_robotDrive.tankDrive(speed, speed);
        System.out.println(i);
    }
    //m_leftFtrMotor.setNeutralMode(NeutralMode.Brake);
    //m_rightFrtMotor.setNeutralMode(NeutralMode.Brake);
    //m_leftRrMotor.setNeutralMode(NeutralMode.Brake);
    //m_rightRrMotor.setNeutralMode(NeutralMode.Brake);

  //  m_robotDrive.tankDrive(speed, speed);
    //setTimeout(timeout);
  }
  public void turnAuton(final double speed, int i){
    //setTimeout(timeout);
    for(i = 0; i <= 10000; i++)
    {
        m_robotDrive.tankDrive(-speed, speed);
        System.out.println(i);
    }
    //m_leftFtrMotor.setNeutralMode(NeutralMode.Brake);
    //m_rightFrtMotor.setNeutralMode(NeutralMode.Brake);
    //m_leftRrMotor.setNeutralMode(NeutralMode.Brake);
    //m_rightRrMotor.setNeutralMode(NeutralMode.Brake);
   
    //m_robotDrive.tankDrive(-speed, speed);//set negitive to turn left
  }
  public void StopAuton(int i){
    //setTimeout(timeout);
    for(i = 0; i <= 10000; i++)
    {
        m_robotDrive.tankDrive(0, 0);
        System.out.println(i);
    }
  }
}
