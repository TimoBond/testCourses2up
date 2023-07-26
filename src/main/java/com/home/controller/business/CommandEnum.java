package com.home.controller.business;

public enum CommandEnum {
    LOGIN {
        {
            command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            command = new LogoutCommand();
        }
    },
    FIND_USER_BY_TYPE {
        {
            command = new FindUsersByTypeCommand();
        }
    },

    COURSE_MANAGE {
        {
            command = new CourseManageCommand();
        }
    },
    LECTURE_COMMAND {
        {
            command = new LectureManageCommand();
        }
    },
    REGISTRATION_STUDENT {
        {
            command = new RegistrationStudent();
        }
    },
    GO_REGISTRATION {
        {
            command = new GoRegistration();
        }
    }, DELETE_USER {
        {
            command = new DeleteUser();
        }
    }, GO_UPDATE_USER_COMMAND {
        {
            command = new GoUpdateUserCommand();
        }
    }, UPDATE_USERS_COMMAND {
        {
            command = new UpdateUsersCommand();
        }
    }, GO_MENU_COMMAND {
        {
            command = new GoMenuCommand();
        }
    }, COMMAND_COURSES_MANAGEMENT {
        {
            command = new CommandCoursesManagement();
        }
    }, GRADE_COMMAND{
    {
        command = new GradeCommand();
    }
    }, GO_TO_COURSE{
        {
            command = new GoToCourse();
        }
    }, NEW_GRADE_COMMAND{
        {
            command = new NewGradeCommand();
        }
    }, STUDENTS_BY_LECTURE{
        {
            command = new StudentsByLecture();
        }
    }, UP_GRADES_STUDENT{
        {
            command = new UpGradesStudent();
        }
    };
    Command command;

    public Command getCommand() {
        return command;
    }
}
