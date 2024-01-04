'use client'

import { Background } from "@/src/shared/layout";
import {Typography, Button, Box, Stack} from "@mui/material";

import {Form} from "react-hook-form";
import {RegistrationFormPersonalData, RegistrationFormContactInformation, SendRegistrationForm, RegistrationFormAvatar} from "@/src/feature/registrationUser";

export const RegistrationForm = () => {
  return (
    <Background>
      <Form {...methods} >
        <form action={SendRegistrationForm}>
          <Stack className={""} direction="column" >
            <Typography variant="h4">Регистрация</Typography>
            <RegistrationFormPersonalData />
            <Box className={"flex lg:flex-row flex-col"}>
              <RegistrationFormContactInformation />
              <RegistrationFormAvatar />
            </Box>
            <Box className={"flex justify-end w-full mt-3"}>
              <Button variant="contained" className={"lg:w-fit w-full"} type={"submit"}>
                Зарегистрироваться
              </Button>
            </Box>
          </Stack>
        </form>
      </Form>
    </Background>
  )
}
