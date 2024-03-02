package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Spamp;

public class autonShoot extends Command {
    private final Spamp m_spamp;

    public autonShoot(Spamp subsystem) {
        m_spamp = subsystem;
        addRequirements(m_spamp);
    }


    
    @Override
    public void initialize() {
        m_spamp.deployShooter();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_spamp.speakerAutonShoot();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_spamp.stopall();
        m_spamp.retractShooter();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return !m_spamp.isNoteLeavingSpamp() && !m_spamp.isNoteInSpamp();
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
