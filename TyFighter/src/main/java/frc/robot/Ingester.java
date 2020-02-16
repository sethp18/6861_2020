/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Ingester {

    private SpeedController m_sweep = new WPI_VictorSPX(2);
 //   private WPI_TalonSRX m_ingLift = new WPI_TalonSRX(13);
    public XboxController m_driverController1 = new XboxController(0);
    //public XboxController m_driverController2 = new XboxController(1);
    //private int flag =0;

/*    public void ingesterInit() {
        m_ingLift.setSelectedSensorPosition(0);
        m_ingLift.setNeutralMode(NeutralMode.Brake);
        SmartDashboard.putNumber("Ingester Lift Position", m_ingLift.getSelectedSensorPosition());
    }
*/

    public void ingesterSweep() {
        if (m_driverController1.getTriggerAxis(Hand.kLeft) > 0.1) {
            m_sweep.set(m_driverController1.getTriggerAxis(Hand.kLeft) * -1);
        }
        if (m_driverController1.getTriggerAxis(Hand.kRight) > 0.1) {
            m_sweep.set(m_driverController1.getTriggerAxis(Hand.kRight));
        }
        if (m_driverController1.getTriggerAxis(Hand.kRight) < 0.1 & m_driverController1.getTriggerAxis(Hand.kLeft) < 0.1) {
            m_sweep.set(0.0);
        }
        
        SmartDashboard.putNumber("Left Trigger Value: ", m_driverController1.getTriggerAxis(Hand.kLeft));
        SmartDashboard.putNumber("Right Trigger Value: ", m_driverController1.getTriggerAxis(Hand.kRight));
    }

   /* public void ingesterLift() {
        SmartDashboard.putNumber("Ingester Lift Position", 1234);

        if(m_driverController2.getBumperPressed(Hand.kLeft) & m_ingLift.getSelectedSensorPosition() < 1000)
        {
            m_ingLift.set(-0.2);
            flag = 0;
        }
        if(m_ingLift.getSelectedSensorPosition() == 1000 & flag == 0)
        {
            m_ingLift.set(.0);
        }
        if(m_driverController1.getBumperPressed(Hand.kLeft) & m_ingLift.getSelectedSensorPosition() >= 1000 & m_ingLift.getSelectedSensorPosition() < 4150 )
        {
            m_ingLift.set(-0.2);
            flag = 0;
        }
        if(m_ingLift.getSelectedSensorPosition() == 4150 & flag == 0)
        {
            m_ingLift.set(.0);
        }


        if(m_driverController2.getBumperPressed(Hand.kRight) & m_ingLift.getSelectedSensorPosition() > 1000)
        {
            m_ingLift.set(0.5);
            flag = 1;
        }
        if(m_ingLift.getSelectedSensorPosition() == 1000 & flag == 1)
        {
            m_ingLift.set(.0);
        }
        if(m_driverController2.getBumperPressed(Hand.kRight) & m_ingLift.getSelectedSensorPosition() <= 1000 & m_ingLift.getSelectedSensorPosition() > 2 )
        {
            m_ingLift.set(0.5);
            flag = 1;
        }
        if(m_ingLift.getSelectedSensorPosition() == 0 & flag == 1)
        {
            m_ingLift.set(.0);
        }
    }
    */
}
